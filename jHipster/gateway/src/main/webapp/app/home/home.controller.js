(function () {
    'use strict';

    angular
        .module('gatewayApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'Principal', 'Word', 'LoginService', '$state'];

    function HomeController($scope, Principal, Word, LoginService, $state) {
        var vm = this;
        var sentenceParts = {};

        vm.account = null;
        vm.sentence = "";
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.register = register;
        $scope.$on('authenticationSuccess', function () {
            getAccount();
        });

        getAccount();



        setInterval(function () {
            Rx.Observable
                .concat(Rx.Observable.startAsync(function () {
                    return Word.get({name: "subject"}).$promise;
                }), Rx.Observable.startAsync(function () {
                    return Word.get({name: "verb"}).$promise;
                }))
                .map(function (it) {
                    return it.word;
                })
                .reduce(function (a, b) {
                    return a + b + " ";
                }, "")
                .subscribe(function (sentence) {
                    vm.sentence = sentence;
                });
        }, 5000);

        function updateSentence() {
            vm.sentence = sentenceParts.subject;
        }

        function getAccount() {
            Principal.identity().then(function (account) {
                vm.account = account;
                vm.isAuthenticated = Principal.isAuthenticated;
            });
        }

        function register() {
            $state.go('register');
        }
    }
})();
