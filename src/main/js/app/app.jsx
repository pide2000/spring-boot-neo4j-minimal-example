const React = require('react');
const client = require('./helpers/client');
import RaisedButton from 'material-ui/RaisedButton';
import { withStyles } from 'material-ui/styles';
import ButtonAppBar from './buttonAppBar';

export default class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {foods: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/foods'}).then(response => {
            this.setState({foods: response.entity._embedded.foods});
        });
    }

    render() {
        return (
            <div>
                <h1>Test</h1>
                <FoodsList foods={this.state.foods}/>
            </div>
        )
    }
}

class FoodsList extends React.Component{
    render() {
        let foods = this.props.foods.map(food =>
            <Food key={food._links.self.href} food={food}/>
        );
        return (
            <div>
                <ButtonAppBar/>
                <table>
                    <tbody>
                    <tr>
                        <th>Name</th>
                    </tr>
                    {foods}
                    </tbody>
                </table>
                <RaisedButton label="Default" />
            </div>
        )
    }
}

class Food extends React.Component{
    render() {
        return (
            <tr>
                <td><a href={this.props.food._links.self.href}>{this.props.food.name}</a></td>
            </tr>
        )
    }
}