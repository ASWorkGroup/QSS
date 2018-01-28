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

$(document).ready(function(){
    $.get("/master/sysuser/autopage/define/pageattribute.do", function (data, textStatus, jqXHR){
        $.each(data, function(id, define){
            document.title = define.title;
        });
    }, "json");
    $.get("/master/sysuser/autopage/define/searchcondition.do", function (data, textStatus, jqXHR){
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

                // var txtDiv = createColumnDiv(rowDiv, "txt"+define.id, "col-md-1")
                // var itemDiv = createColumnDiv(rowDiv, define.id, "col-md-1")
                // createSpan(txtDiv, define.displayText,"col-md-12");
                // createTextbox(itemDiv, define.id, define.id);
            }

            i++;
        });
    }, "json");
});


function doQuery(){
    $.post("/master/sysuser/autopage/list/query.do", $('#form1').serialize(), function (data, textStatus, jqXHR){
        alert('aa');
    });
}