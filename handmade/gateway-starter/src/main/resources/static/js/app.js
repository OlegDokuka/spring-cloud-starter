(function () {
    angular.module('sso', ['ngRoute', 'ngResource']).config(
        function ($routeProvider) {

            $routeProvider.otherwise('/');
            $routeProvider.when('/', {
                templateUrl: 'home.html',
                controller: 'home'
            }).when('/sentence', {
                templateUrl: 'sentence.html',
                controller: 'sentence'
            });

        }).controller('navigation', function ($scope, $http, $window, $route) {
        $scope.tab = function (route) {
            return $route.current && route === $route.current.controller;
        };
        if (!$scope.user) {
            $http.get('/uaa/user').success(function (data) {
                try {
                    data = JSON.parse(data);
                } catch (e) {

                }
                $scope.user = data;
                $scope.authenticated = true;
            }).error(function () {
                $scope.authenticated = false;
            });
        }
        $scope.logout = function () {
            $http.post('/logout', {}).then(function () {
                delete $scope.user;
                $scope.authenticated = false;
                // Force reload of home page to reset all state after logout
                $window.location.hash = '/';
            }, function () {
                delete $scope.user;
                $scope.authenticated = false;
                // Force reload of home page to reset all state after logout
                $window.location.hash = '/';
            });
        };
    }).controller('home', function () {
    }).controller('sentence', ['$scope', 'Word', function ($scope, Word) {
        setInterval(function () {
            Rx.Observable
                .concat(Rx.Observable.startAsync(function () {
                    return Word.get({name: "subject"}).$promise;
                }), Rx.Observable.startAsync(function () {
                    return Word.get({name: "verb"}).$promise;
                }), Rx.Observable.startAsync(function () {
                    return Word.get({name: "article"}).$promise;
                }), Rx.Observable.startAsync(function () {
                    return Word.get({name: "adjective"}).$promise;
                }), Rx.Observable.startAsync(function () {
                    return Word.get({name: "noun"}).$promise;
                }))
                .map(function (it) {
                    return it.word;
                })
                .reduce(function (a, b) {
                    return a + b + " ";
                }, "")
                .subscribe(function (sentence) {
                    $scope.sentence = sentence;
                }, function () {
                    $scope.sentence = "shit happens";
                });
        }, 5000);
    }]);
})();