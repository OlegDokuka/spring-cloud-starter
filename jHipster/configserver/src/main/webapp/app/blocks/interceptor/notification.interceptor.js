(function() {
    'use strict';

    angular
        .module('JHipsterConfigServerApp')
        .factory('notificationInterceptor', notificationInterceptor);

    notificationInterceptor.$inject = ['$q', 'AlertService'];

    function notificationInterceptor ($q, AlertService) {
        var service = {
            response: response
        };

        return service;

        function response (response) {
            var alertKey = response.headers('X-JHipsterConfigServerApp-alert');
            if (angular.isString(alertKey)) {
                AlertService.success(alertKey, { param : response.headers('X-JHipsterConfigServerApp-params')});
            }
            return response;
        }
    }
})();
