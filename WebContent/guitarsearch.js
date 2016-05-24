/**
 * 
 */
function search(){
	var search=$("#search").val();
	$.getJSON("search",{search:search}, function(json) {
		var html="";
			for(var i=0;i<json.length;i++){
				var serialNumber=json[i].serialNumber;
				var price=json[i].price;
				var builder=json[i].builder;
				var model=json[i].model;
				var type=json[i].type;
				var backwood=json[i].backwood;
				var topwood=json[i].topwood;
				var numStrings=json[i].numStrings;
				html+="<tr><td>"+serialNumber+"</td><td>"+builder+"</td><td>"+model+"</td><td>"+type+"</td>";
				html+="<td>"+numStrings+"</td><td>"+topwood+"</td><td>"+backwood+"</td><td>"+price+"</td></tr>";
			}
		
		$(".table").append(html);
	});
}