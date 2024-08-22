import {Component} from "react";

export class Header extends Component {
    render() {
        return (
            <>
                <h1>Header</h1>
                <h2>{this.props.id || 'default'}</h2>
                <h2>{this.props.dataHeader}</h2>
                <h2>{this.props.children}</h2>
            </>
        )
    }
}

// export default Header;
