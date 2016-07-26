<html>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	  loadInfo();
	});
	//加载数据
	function loadInfo() {
		$.getJSON("/test1",null,function(jsonData){
			var html =[];

			$(jsonData).each(function(index,item){
				html.push("<tr>");
				html.push("<td>");
				html.push(item.PATIENT_NAME);
				html.push("</td>");
				html.push("<td>");
				html.push(item.PATIENT_NAME);
				html.push("</td>");
				html.push("<td>");
				html.push(item.PATIENT_NAME);
				html.push("</td>");
				html.push("<td>");
				html.push(item.PATIENT_NAME);
				html.push("</td>");
				html.push("</tr>")
			});
            $("#info").html(html.join(''));
		});

	}
</script>
<body>
	<h1>${message}</h1>
    <img src="/images/cat.jpg"/>
    <table>
		<thead></thead>
		<tbody id="info"></tbody>
	</table>
</body>
</html>