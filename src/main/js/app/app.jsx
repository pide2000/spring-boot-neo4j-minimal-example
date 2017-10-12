const React = require('react');
const client = require('./helpers/client');
import ButtonAppBar from './mainComponents/buttonAppBar';
import FoodsList from './mainComponents/foodsList';

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
                <ButtonAppBar/>
                <FoodsList foods={this.state.foods}/>
            </div>
        )
    }
}

