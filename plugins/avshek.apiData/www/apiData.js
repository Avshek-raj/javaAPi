var exec = require('cordova/exec');

exports.getData = function (arg0, success, error) {
    exec(success, error, 'apiData', 'getData', [arg0]);
};
