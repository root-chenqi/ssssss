<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="">
    <select name="houseRegion" onchange="selectAll()">
        <option value="未选择">未选择</option>
        <option value="沙河口区">沙河口区</option>
        <option value="高新园区">高新园区</option>
        <option value="甘井子区">甘井子区</option>
    </select>
    <select name="houseType" onchange="selectAll()">
        <option value="未选择">未选择</option>
        <option value="2室1厅">2室1厅</option>
        <option value="1室1厅">1室1厅</option>
    </select>
    <select name="housePrice" onchange="selectAll()">
        <option value="">未选择</option>
        <option value="1000">1000~2000</option>
        <option value="2000">2000~3000</option>
        <option value="3000">3000~4000</option>
    </select>
</form>
<table>
    <tr>
        <th>地区</th>
        <th>户型</th>
        <th>价格</th>
    </tr>
    <tbody id="tb">
    </tbody>
</table>

<script>
    function selectAll(){

        //获取所有select
        var sels = document.getElementsByTagName("select");
        //alert(sels[0].value);
        var xmlHttp = null;
        if(window.XMLHttpRequest){
            xmlHttp = new XMLHttpRequest();
        }else{
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlHttp.onreadystatechange = function(){
            if(xmlHttp.status == 200 && xmlHttp.readyState == 4){
                var house = eval("("+xmlHttp.responseText +")");
                var _tb = document.getElementById("tb");
                _tb.innerHTML="";
                for(var i=0;i<house.length;i++)
                {
                    var _tr = _tb.insertRow();
                    var _td1 = _tr.insertCell();
                    var _td2 = _tr.insertCell();
                    var _td3 = _tr.insertCell();
                    _td1.innerText =house[i].houseRegion;
                    _td2.innerText =house[i].houseType;
                    _td3.innerText =house[i].housePrice;
                }
            }
        }
       /*  //get方式提交
        var str="";
        for(var i = 0;i<sels.length;i++){
            if(sels[i].value!="未选择"){
               str += sels[i].name +"="+ sels[i].value+"&";
            }
        }
        var str2 = str.substr(0,str.length-1);
        xmlHttp.open("get", "selectAll.do?"+str2, true);
        //去掉逗号
        xmlHttp.send(); 
       */
       
       //post方式提交
        var h={};
        for(var i = 0;i<sels.length;i++){
            if(sels[i].value!="未选择"){
            	h[sels[i].name] = sels[i].value;
            }
        }
        xmlHttp.open("post", "selectAll.do", true);
        xmlHttp.setRequestHeader("Content-Type","application/json;charset=utf-8");
        //去掉逗号
        xmlHttp.send(JSON.stringify(h));//把json转字符串 
    }
</script>
</body>
</html>