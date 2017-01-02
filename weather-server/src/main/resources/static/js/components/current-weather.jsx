/**
 * Created by james on 02/01/2017.
 */
define(function (require) {

    var React = require('react');
    var $ = require('jquery');

    var CurrentWeather = React.createClass({
        getInitialState: function() {
            return {
                selectedCity:'',
                data: {
                        name:'',
                        weather: [  {description:''} ],
                        main: { temp: ''},
                        sys: {sunrise: '',sunset: ''}
                }
            };
        },
        getTitle: function() {
            if(this.state.selectedCity){
                return(<h4>Current Weather in {this.state.selectedCity}</h4>);
            } else {
                return(<h4>Select City:</h4>);
            }
        },
        changeCity: function(event) {
            var self = this;
            var selCity = event.target.value;
            var url = "/current?city=" + selCity;
            this.setState({selectedCity:selCity});
            console.log("Selected City:" + selCity);
            console.log("Json URL:" + url);
            $.getJSON(url,function(o) {
                console.log(o);
                self.setState({data:o});
            });
        },
        render: function() {
            return (
                <div>
                    <div className="page-title">{this.getTitle()}</div>
                    <select onChange={this.changeCity} value={this.state.selectedCity}>
                        <option value="">Choose City...</option>
                        <option value="London">London</option>
                        <option value="Moscow">Moscow</option>
                    </select>
                    <hr />
                    <table>

                        <tr>
                            <td>City</td>
                            <td>{this.state.data.name}</td>
                        </tr>
                        <tr>
                            <td>Temperature</td>
                            <td>{this.state.data.main.temp} C / {this.state.data.main.temp} F</td>
                        </tr>
                        <tr>
                            <td>Sunrise</td>
                            <td>{this.state.data.sys.sunrise}</td>
                        </tr>
                        <tr>
                            <td>Sunset</td>
                            <td>{this.state.data.sys.sunset}</td>
                        </tr>
                        <tr>
                            <td>Description</td>
                            <td>{this.state.data.weather[0].description}</td>
                        </tr>
                    </table>
                </div>
            );
        }

    });
    return CurrentWeather;
});
