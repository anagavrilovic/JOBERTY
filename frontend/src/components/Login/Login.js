import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { useState } from "react";
import { login } from "../../features/user"

import classes from "./Login.module.css";
import AuthentificationService from "../../services/AuthentificationService";


function Login(props) {
    const [error, setError] = useState(false);

    const dispatch = useDispatch();
    const navigate = useNavigate();

    
    function submitHandler(event) {
        event.preventDefault();
        
        const credentials = {
            email: event.target[0].value,
            password: event.target[1].value
        }
        
        AuthentificationService.login(credentials)
        .then((response) => {
            dispatch(login(response.data));
            navigate("/home");
        })
        .catch(() => {
            setError(true);
        })
    }

    return (
        <div className={classes.login}>
            <h1 className={classes.caption}>Log in</h1>
            <form onSubmit={submitHandler} className={classes.form}>
                <div className={classes.errorMessage}> {error ? "Wrong email or password! Try again." : ""}</div>

                <div className={classes.formItem}>
                    <input type="text" required placeholder="Email" onChange={() => setError(false)} />
                </div>
                <div className={classes.formItem}>
                    <input type="password" required placeholder="Password" onChange={() => setError(false)} />
                </div>

                <button className={classes.buttonLogIn}>Log in</button>
                <a href="/#" className={classes.registerLink} onClick={() => props.navigateToRegister()} >
                    Don't have an account? Register here.
                </a>
            </form>
        </div>
    );
}

export default Login;
