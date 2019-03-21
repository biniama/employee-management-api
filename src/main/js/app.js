const React = require('react');
const ReactDOM = require('react-dom');

//client is custom code that configures rest.js to include support for HAL, URI Templates, and other things. It also sets the default Accept request header to application/hal+json.
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            employees : []
        };
    }

    componentDidMount() {

        //client, a Promise compliant instance of rest.js
        client({
            method: 'GET',
            path: '/api/employees'
        })
        .done(response => {
            this.setState({employees: response.entity._embedded.employees})
        });
    }

    render() {
        return (
            <EmployeeList employees={this.state.employees}/>
        )
    }
}

class EmployeeList extends React.Component {
    render() {
        const employees = this.props.employees.map(employee =>
            <Employee key={employee._links.self.href} employee={employee} />
        );

        return (
            <table>
                <tbody>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Description</th>
                </tr>
                {employees}
                </tbody>
            </table>
        )
    }
}

//splitting your app up into small components that each do one job will make it easier to build up functionality in the future.
class Employee extends React.Component {

    render() {

        const employee = this.props.employee;

        return (
            <tr>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.description}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
);