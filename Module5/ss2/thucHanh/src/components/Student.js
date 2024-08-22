import {Component} from "react";

export default class Student extends Component{
    constructor() {
        super();
        this.state = {
            studentName: '',
            studentList : ['Nguyen Van A', 'Nguyen Van B'],
            customerList : [{name : "Nguyen Van A", bd: "23/12/2004", gt: "nam",dc: "Da Nang"},
                {name : "Nguyen Van b", bd: "23/12/2005", gt: "nam",dc: "Da Nang1"},
                {name : "Nguyen Van C", bd: "12/12/2006", gt: "nu",dc: "Quang Bình"}]
        }
    }
    handleInput(value) {
        // console.log(value)
        this.setState({
            studentName: value
        })
    }

    addBtn() {
        this.setState({
            studentName : '',
            studentList : [this.state.studentName, ...this.state.studentList]
        })
    }

    componentWillUnmount() {
        console.log("componentWillUnmount")
    }

    render() {
        {
            console.log('Init || render')
        }
        return (
            <>
                <input type="text" value={this.state.studentName}
                    onChange={(event) => this.handleInput(event.target.value)}
                />

                <button onClick={() => this.addBtn()}>Add</button>
                <ul>
                    {
                        this.state.customerList.map((student, index) => (
                            <li key={index}>{student.name}</li>,
                            <li key={index}>{student.bd}</li>,
                            <li key={index}>{student.gt}</li>,
                            <li key={index}>{student.dc}</li>
                        ))
                    }
                </ul>
            </>
        )
    }
}
