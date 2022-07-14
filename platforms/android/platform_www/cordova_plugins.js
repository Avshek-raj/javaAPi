cordova.define('cordova/plugin_list', function(require, exports, module) {
  module.exports = [
    {
      "id": "avshek.apiData.apiData",
      "file": "plugins/avshek.apiData/www/apiData.js",
      "pluginId": "avshek.apiData",
      "clobbers": [
        "cordova.plugins.apiData"
      ]
    }
  ];
  module.exports.metadata = {
    "avshek.apiData": "1.0.0"
  };
});