let messenger = angular.module("messenger", []);
messenger.controller("registerController", ['$scope', '$http', function ($scope, $http) {

    $scope.countries = [];
    $scope.cities = [];

    $scope.userData = {
        email: '',
        birthday: '',
        firstName: '',
        lastName: '',
        cityId: -1,
        countryId: -1,
        password: '',
        role: ''
    };

    $scope.init = function () {
        $scope.loadCountries();
    };

    $scope.loadCountries = function () {
        $http.get(GET_COUNTRIES_URL).then(function success(response) {
            $scope.countries = response.data;
        });
    };

    $scope.loadCities = function () {
        $http.get(GET_CITIES_BY_COUNTRY_URL + '?country=' + $scope.userData.countryId).then(function success(response) {
            $scope.cities = response.data;
        });
    };
    
    $scope.register = function () {
        $http.post(SAVE_USER_URL, JSON.stringify($scope.userData));
    }
}]);