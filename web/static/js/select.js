(function ($) {
    $.fn.extend({
        "wy_inselect": function (options) {
            console.log(options);
            if (!isValid(options)) return this;
            var $Id = $(this);
            var last;
            $Id.find(".wyinput-drop").css("width", $(".wyinput-group input").outerWidth() + "px").hide();
            // $Id.find(".wyinput-group input").keyup(function (event) {
            // last = event.timeStamp;
            setTimeout(function () {    //设时延迟50ms执行
                // if (last - event.timeStamp === 0)
                //如果时间差为0（也就是你停止输入0.5s之内都没有其它的keyup事件发生）
                // {
                let arr = searchIndex($Id, options);
                loadDrop($Id, arr);
                // }
            }, 50);
            // });
            $Id.find(".wyinput-drop").delegate(".drop-line a", "click", function () {
                var html = $(this).html();
                $(this).parents(".wyinput-drop").siblings(".wyinput-group").find("input").val(html);
                $Id.find(".wyinput-drop").hide()
            })

        }
    })

    //监测参数是否合法
    function isValid(options) {
        return !options || (options && typeof options === "object") ? true : false;
    }

    //加载下拉框
    function loadDrop($Id, arr) {
        var html = "";
        if (arr.length === 0) {
            $Id.find(".wyinput-drop").hide().html("");
            return;
        }
        $.each(arr, function (idx, obj) {
            html += '<p style="height:14px">' + '<a href="javascript:void(0);">' + obj.name + '</a></p>';
        });
        $Id.find(".wyinput-drop").html(html).show();
        $('.wyinput-drop p a').each(function () {
            $(this).on('click', function () {
                let text = $(this).text().split('： ')[1];
                $Id.find(".wyinput-group input").val(text);
                $('#search_ok').click();
            })
        });
    }

    //模糊查询
    function searchIndex($Id, options) {
        var $input = $Id.find(".wyinput-group input");
        var keywords = $input.val();
        console.log("查询的关键词：" + keywords.trim());
        var arr = [];
        if (keywords === "" || keywords === " ") {
            return arr;
        }
        $.each(options, function (idx, obj) {
            if (obj.name.substr(4, obj.name.length).indexOf(keywords.trim()) >= 0) {
                let category = obj.name.substr(0, 4);
                if (category === 'good') {
                    arr.push({name: '发货单号： ' + obj.name.substr(4, obj.name.length)});
                } else if (category === 'user') {
                    arr.push({name: '用户名： ' + obj.name.substr(4, obj.name.length)});
                }
            }
        });
        console.log("匹配结果：" + arr);
        return arr;
    }

})(window.jQuery);

$(function () {
    $('.wyinput-drop').hide();
    $('.search').bind('input propertychange', function () {
        let queryWord = $(this).val();
        $.ajax({
            url: "adminServlet",
            data: {action: "fuzzyQuery", queryWord: queryWord},
            dataType: "json",
            type: "POST",
            success: function (data) {
                let list = data.name;
                let newData = [];
                for (let i = 0; i < list.length; i++) {
                    newData.push({"name": list[i]});
                }
                $("#myInput").wy_inselect(newData);
            }
        })
    });
});