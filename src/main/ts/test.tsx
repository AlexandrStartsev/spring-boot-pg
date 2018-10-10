import * as React from "react";
import * as ReactDOM from "react-dom";

const FancySinglePageApp = () => <div>
    <h3>Fancy single page app</h3>
    <br/>
    <a href="/index.html">Back</a>
</div>

ReactDOM.render(<FancySinglePageApp/>, document.body);