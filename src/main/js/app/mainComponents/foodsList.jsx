const React = require('react');

class FoodsList extends React.Component{
    render() {
        let foods = this.props.foods.map(food =>
            <Food key={food._links.self.href} food={food}/>
        );
        return (
            <div>
                <table>
                    <tbody>
                    <tr>
                        <th>Name</th>
                    </tr>
                    {foods}
                    </tbody>
                </table>
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

module.exports = FoodsList;