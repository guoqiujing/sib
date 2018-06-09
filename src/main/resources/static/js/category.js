// /**
//  * Created by Administrator on 2018/6/7.
//  */
$.fn.category = function(pName,cName){

    var p = $(this).find('select[lay-filter=topCategory]');
    var a = $(this).find('select[lay-filter=category]');
    var cityList = [];
    showP(provinceList);
    showC(cityList);
    function showP(provinceList) {
        p.html('');
        is_pName = false;
        for (var i in provinceList) {
            if(pName==provinceList[i].name){
                is_pName = true;
                cityList = provinceList[i].lowerCategories;
                p.append("<option selected value='"+provinceList[i].name+"'>"+provinceList[i].name+"</option>")
            }else{
                p.append("<option value='"+provinceList[i].name+"'>"+provinceList[i].name+"</option>")
            }
        }
        if(!is_pName){
            cityList = provinceList[0].lowerCategories;
        }
    }

    function showC(areaList) {
        a.html('');
        for (var i in areaList) {
            if(cName==areaList[i]){
                a.append("<option selected value='"+areaList[i].name+"'>"+areaList[i].name+"</option>")
            }else{
                a.append("<option value='"+areaList[i].name+"'>"+areaList[i].name+"</option>")
            }
        }
    }
    form.render('select');
    form.on('select(topCategory)', function(data){
        pName = data.value;
        showP(provinceList);
        showC(cityList);
        form.render('select');
    });

}
//向服务器获取Categories
var provinceList;
$(document).ready(function(e) {
    $.ajax({
        type: "get",
        async: false,
        url: "/category/list",
        success: function(res) {
            if(res.code=='0'){
                provinceList = res.data[0].lowerCategories
                console.log(provinceList)
            }
        },
        error: function(res) {
            console.log(res)
        }
    });

})