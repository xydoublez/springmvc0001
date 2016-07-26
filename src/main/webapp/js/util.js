/**
 * Created by Administrator on 2016-07-26.
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}
function CommonAjax(funcsucobj, funcbeforeobj, dataStr, url, isAsync) {
/// <summary>
/// 通用ajax方法
/// </summary>
/// <param name="funcsucobj">成功提交后执行的方法</param>
/// <param name="funcbeforeobj">提交前执行方法</param>
/// <param name="dataStr">ajax提交数据</param>
    var type = typeof (dataStr);
    $.ajax({
        type: "POST",
        async: isAsync == undefined ? false : isAsync,
        processData: type == "object" ? false : true,
        beforeSend: funcbeforeobj,
        url: url == undefined ? "../Ajax/ReSendServer.aspx" : url,
        data: dataStr,
        success: funcsucobj,
        cache:false
    });
}