
angular.module('marketplace-core').controller('NewOfertaController', function ($scope, $location, locationParser, flash, OfertaResource , ProductoResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.oferta = $scope.oferta || {};
    
    $scope.productoList = ProductoResource.queryAll(function(items){
        $scope.productoSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("productoSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.oferta.producto = {};
            $scope.oferta.producto.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The oferta was created successfully.'});
            $location.path('/Oferta');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        OfertaResource.save($scope.oferta, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Oferta");
    };
});