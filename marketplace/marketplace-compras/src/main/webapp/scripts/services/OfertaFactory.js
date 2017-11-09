angular.module('marketplace-compras').factory('OfertaResource', function($resource){
    var resource = $resource('../markeplace-core/rest/oferta/:OfertaId',{OfertaId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});