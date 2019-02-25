var ffServiceApp = angular.module('ffServiceApp', []);

ffServiceApp.controller('ffController', function($scope, $http) {

    $scope.home = function() {
        $http.get('http://localhost:8080/featureflags')
            .then(function (response){
                $scope.ffresults = response.data;
                console.log("data:" + response.data);
                console.log("status:" + response.status);
            }).catch(function(response) {
            console.error('Error occurred:', response.status, response.data);
        }).finally(function() {
            console.log("Call finished")
        });
    };

    $scope.saveFeatureFlag = function(data) {
        angular.forEach(data, function(values, key){
            values.value = values.checked == true ? 1 : 0;

            $http.post('http://localhost:8080/featureflags', values)
                .then(function (response) {
                    console.log("data:" + response.data);
                    console.log("status:" + response.status);
                }).catch(function(response) {
                console.error('Error occurred:', response.status, response.data);
            }).finally(function() {
                console.log("Save Call finished for " + values.country)
            });
        });

        alert("Update operation complete");
    }
});
