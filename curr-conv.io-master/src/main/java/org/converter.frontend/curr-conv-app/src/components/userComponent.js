import React from 'react';

export default class UserComponent extends React.Component{
    
    constructor(props){
        super(props);
        this.state = {
            quantity: 0,
            initCurrency: '',
            finCurrency: '',
            response: ''
        }   
    }
    
    handleSubmit = event => {
        event.preventDefault();

        const data = {
            quantity : this.state.quantity,
            initCurrency : this.state.initCurrency,
            finCurrency : this.state.finCurrency
        };

        //console.log(this.props);
        //console.log(data);
        
        axios.post('http://localhost:8080/api/v1/converter', data).then(res => {
            const response = res.data;
            this.setState({response});
            //console.log(response);
        });
    
    };

    handleChange = (event) => {
        let key = event.target.name;
        let value = event.target.value;
        this.setState({
            [key]: value
        });
        //console.log(this.state);
      };

    render(){
        return (
            <div>
              <form onSubmit={this.handleSubmit}>
                <p>
                <label>
                  Quantity:
                  <input type="number" name="quantity" onChange={this.handleChange.bind(this)} value={this.state.quantity} />
                </label>
                </p>
                <p>
                <label>
                  From:
                  <input type="text" name="initCurrency" onChange={this.handleChange.bind(this)} value={this.state.initCurrency} />
                </label>
                </p>
                <p>
                <label>
                  To:
                  <input type="text" name="finCurrency" onChange={this.handleChange.bind(this)} value={this.state.finCurrency} />
                </label>
                </p>
                <button type="submit">Add</button>
              </form>
        <ul>{this.state.response}</ul>
            </div>
          )
    }
}