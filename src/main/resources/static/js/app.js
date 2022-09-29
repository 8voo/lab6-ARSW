
var App = (function(){
    

    var getBlueprints = function(){
        var autname = $("#autname").val();
        if (autname == ""){
            alert("cagastes");
        }        
        else{
            apimock.getBlueprintsByAuthor(autname,crearData);
        }
    };
    var crearData = function(autdata){
        var bps = autdata;
        var newPbs = bps.map(function(bp){
            return {
                name : bp.author,
                points : bp.points.length
            }
        });
        var totalPuntos = newPbs.reduce((curr, {points}) => curr+points, 0);
        $('#total-points').text("Total user points: " + totalPuntos);
        var bodyTable = $('tbody');
        bodyTable.html('');
        newPbs.map(function(bp){
            var table = $('#table');
            
            table.append("ks<tr> \n <td>"+ bp.name +"</td> \n <td>"+ bp.points +"</td> \n <td><button>Open</button></td> \n </tr>");
        });
    }
    
    return{
        getBlueprints : getBlueprints
    }
})();