
angular.module('marketplace-app').controller('NewUsuarioController', function ($scope, $rootScope, $location, locationParser, flash, UsuarioResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.usuario = $scope.usuario || {};
    
    if($rootScope.currentUser != undefined && $rootScope.currentUser.user.rol == "ADMINISTRADOR"){
	    $scope.rolList = [
	        "ADMINISTRADOR",
	        "CLIENTE",
	        "PROVEEDOR"
	    ];
    }else{
	    $scope.rolList = [
	        "CLIENTE"
	    ];    	
    }
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The usuario was created successfully.'});
            $location.path('/Usuarios');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        UsuarioResource.save($scope.usuario, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Usuarios");
    };
});