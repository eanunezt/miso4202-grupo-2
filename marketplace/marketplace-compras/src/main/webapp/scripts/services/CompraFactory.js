angular.module('marketplace-app').factory('CompraResource', function($resource){
    var resource = $resource('rest/compras/:CompraId',{CompraId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});