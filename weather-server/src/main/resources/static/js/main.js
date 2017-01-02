/**
 * Created by james on 02/01/2017.
 */
require.config({
    paths: {
        "jquery":"bower_components/jquery/dist/jquery.min",
        "react":"bower_components/react/react-with-addons",
        "react-dom":"bower_components/react/react-dom",
        "babel": "bower_components/requirejs-react-jsx/babel-5.8.34.min",
        "jsx": "bower_components/requirejs-react-jsx/jsx",
        "text": "bower_components/requirejs-text/text"
    }

});

require([
    'jsx!components/main.jsx']
    ,
    function(JsxMain) {
        var jsxMain = new JsxMain();
        jsxMain.init('main');
    });




