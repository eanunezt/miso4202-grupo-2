var directives = {};

(function(){
    directives.numeric = function(){
       return {
          require: 'ngModel',
          link: function(scope, elem, attr, ngModel) {
              ngModel.$parsers.unshift(function(value) {
                 var valid = /^[0-9]*$/.test(value);
                 return valid ? value : undefined;
                 
              });
          }
       };
    };
    
    directives.stringOnly = function (){ 
       return {
          require: 'ngModel',
          link: function(scope, elem, attr, ngModel) {
              ngModel.$parsers.unshift(function(value) {
                 var valid = /^[a-zA-Z\s]*$/.test(value);
                 return valid ? value : undefined;
                 
              });
          }
       };
    };
    
    directives.email = function (){ 
       return {
          require: 'ngModel',
          link: function(scope, elem, attr, ngModel) {
              ngModel.$parsers.unshift(function(value) {
                 var valid = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(value);
                 return valid ? value : undefined;
                 
              });
          }
       };
    };
    
    $('*[required]').after('<span>*</span>');
})();

module.directive('numeric', directives.numeric)
    .directive('stringonly', directives.stringOnly)
    .directive('email', directives.email);
