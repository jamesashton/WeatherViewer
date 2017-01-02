define(function(require) {
    var React = require('react');
    var ReactDOM = require('react-dom');
    var CurrentWeather = require('jsx!components/current-weather');

    var Main = function() {}
    Main.prototype.init =  function(id) {
        ReactDOM.render(<CurrentWeather/>,document.getElementById(id));
    }
    return Main;
});
