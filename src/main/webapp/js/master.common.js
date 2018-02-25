/**
 * Created by yuanaiqing on 27/1/18.
 */


var createRowDiv= function(parentDiv, id, style){
    var newdiv=$('<div></div>');
    newdiv.attr('id',id);
    if (style != null) {
        newdiv.addClass(style);
    }
    else {
        newdiv.addClass("row");
    }

    parentDiv.append(newdiv);
    return newdiv;
}

var createColumnDiv= function(parentDiv, id, style){
    var newdiv=$('<div></div>');
    newdiv.attr('id',id);
    if (style != null) {
        newdiv.addClass(style);
    }

    parentDiv.append(newdiv);
    return newdiv;
}

var createTextbox= function(parentDiv, id, name, style){
    var newTextbox=$('<input></input>');
    newTextbox.attr('id',id);
    newTextbox.attr('name',name);
    if (style != null) {
        newTextbox.addClass(style);
    }

    parentDiv.append(newTextbox);
    return newTextbox;
}

var createSpan= function(parentDiv, text, style) {
    var newspan = $('<div></div>');
    newspan.html(text + ":&nbsp;");
    if (style != null) {
        newspan.addClass(style);
    }

    parentDiv.append(newspan);
    return newspan;
}

var createFormGroup= function(parentDiv, id, text, style) {
    var groupDiv = $('<div></div>');
    if (style != null){
        groupDiv.addClass("form-group " + style);
    }
    else {
        groupDiv.addClass("form-group");
    }

    var label = $('<label></label>');
    label.attr('for', id);
    label.text(text);
    // label.addClass("col-lg-2");

    var input = $('<input></input>');
    input.attr('type', 'text');
    input.attr('id', id);
    input.attr('name', id);
    input.addClass("form-control");

    groupDiv.append(label);
    groupDiv.append(input);

    parentDiv.append(groupDiv);
    return groupDiv;
}

var createTable  = function(){
    var tb = $('<table></table>');
    // tb.addClass('table table-hover table-bordered');
    tb.addClass('table');
    // tb.addClass('table-hover');
    tb.addClass('table-bordered');

    return tb;
}

var createTHeader = function() {
    var theader = $('<thead></thead>');
    return theader;
}

var createTBody = function() {
    var tbody = $('<tbody></tbody>');
    return tbody;
}

var createHeadCell = function(txt) {
    var th = $('<th></th>');
    th.text(txt);
    return th;
}

var createRow = function() {
    var tr = $('<tr></tr>');
    return tr;
}

var createCell = function(txt) {
    var cell = $('<td></td>');
    cell.text(txt);

    return cell;
}

$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

$(document).ready(function(){
    var pathname = window.location.pathname;
    var pageId = pathname.substring(8, pathname.indexOf('/', 8));
    $.get("/master/"+pageId+"/autopage/define/pageattribute.do", function (data, textStatus, jqXHR){
        $.each(data, function(id, define){
            document.title = define.title;
        });
    }, "json");

    $.get("/master/"+pageId+"/autopage/define/searchcondition.do", function (data, textStatus, jqXHR){
        var searchConditionSize = data.length;
        var i=0;
        var parentDiv = $("#searchCondition");
        var rowDiv = createColumnDiv(parentDiv, "row"+ i, "row")
        $.each(data, function(id, define){
            if (define.type == "string") {

                if (i % 2 == 0) {
                    rowDiv = createColumnDiv(parentDiv, "row" + i, "row")
                }

                createFormGroup(rowDiv, define.id, define.displayText);
            }

            i++;
        });
    }, "json");

    var listitem = {};
    $.get("/master/sysuser/autopage/define/listitem.do", function (data, textStatus, jqXHR){
        listitem = data;
    }, "json");

    var getListLocaleLabel = function(id){
        var item = listitem.filter((p) => {
                return p.id == id;
            });
        return item[0].displayText;
    }

    $("#btnQuery").click(function() {
        var obj = $('#form1').serializeObject();
        var jsonuserinfo = $.toJSON(obj);
        jQuery.ajax( {
            type : 'POST',
            contentType : 'application/json',
            url : '/master/sysuser/autopage/list/query.do',
            data : jsonuserinfo,
            dataType : 'json',
            success : function(data) {
                var tb = createTable();
                //添加head
                var thr = createRow();
                var theader = createTHeader();
                $.each(listitem, function(id, item){
                    var th = createHeadCell(item.displayText);
                    thr.append(th);
                });
                theader.append(thr);
                tb.append(theader);

                //循环渲染数据
                var tbody = createTBody();
                $.each(data, function(id, dataRow){
                    var tr = createRow();
                    $.each(listitem, function(id, item){
                        var value = dataRow[item.id];
                        var td = createCell(value);
                        tr.append(td);
                    });
                    tbody.append(tr);
                });
                tb.append(tbody);

                var parentDiv = $('#searchList');
                parentDiv.empty();
                parentDiv.append(tb);
            },
            error : function(data) {
                alert("error")
            }
        });
    });
});


// function doQuery(){
//     $.post("/master/sysuser/autopage/list/query.do", $('#form1').serialize(), function (data, textStatus, jqXHR){
//         alert($('#form1').serialize());
//     });
// }