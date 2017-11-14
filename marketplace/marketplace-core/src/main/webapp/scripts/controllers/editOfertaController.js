

angular.module('marketplace-app').controller('EditOfertaController', function($scope, $routeParams, $location, flash, OfertaResource , ProductoResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.oferta = new OfertaResource(self.original);
            ProductoResource.queryAll(function(items) {
                $scope.productoSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.oferta.producto && item.id == $scope.oferta.producto.id) {
                        $scope.productoSelection = labelObject;
                        $scope.oferta.producto = wrappedObject;
                        self.original.producto = $scope.oferta.producto;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The oferta could not be found.'});
            $location.path("/Oferta");
        };
        OfertaResource.get({OfertaId:$routeParams.OfertaId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.oferta);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The oferta was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.oferta.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Oferta");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The oferta was deleted.'});
            $location.path("/Oferta");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.oferta.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("productoSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.oferta.producto = {};
            $scope.oferta.producto.id = selection.value;
        }
    });
    
    $scope.get();
});