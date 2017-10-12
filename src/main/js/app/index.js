import React from 'react';
import { render } from 'react-dom';
import { MuiThemeProvider, createMuiTheme } from 'material-ui/styles';
import Application from './app.jsx';

const theme = createMuiTheme();

function App() {
    return (
        <MuiThemeProvider theme={theme}>
            <Application />
        </MuiThemeProvider>
    );
}

render(<App />, document.querySelector('#app'));