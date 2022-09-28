
var App = (function(){
    var getBlueprints = function(author){
        var bps = getBlueprintsByAuthor(author);
        var newPbs = bps.map(function(bp){
            var newBp = {
                name : bp.name,
                points : bp.points.length
            }
        })
    };

    var totalUserPoints = function(){

    };
    return{
        updatePlanos:function(author, callback){
            callback(
                getBlueprintsByAuthor(author)
            )
        }
    }
})();