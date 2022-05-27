//import { useNavigate } from 'react-router-dom';
import { useEffect } from 'react';
//import { useDispatch } from "react-redux";

import classes from './Registration.module.css';

function Registration(props) {
    //const navigate = useNavigate();
    //const dispatch = useDispatch();

    useEffect(() => {

    }, [])

    function registrationHandler() {

    }

    return (
        <div className={classes.login}>
            <h1>Register now!</h1>
            <form onSubmit={registrationHandler} className={classes.form}>

                <div className={classes.formItem}>
                    <input type='text' required placeholder='Common name'/>
                </div>
                <div className={classes.formItem}>
                    <input type='text' required placeholder='Email'/>
                </div>
                <div className={classes.formItem}>
                    <input type='text' required placeholder='Organization'/>
                </div>
                <div className={classes.formItem}>
                    <input type='text' required placeholder='Organization Unit'/>
                </div>

                <select name="CountryCode" defaultValue="" className={classes.select}>

                </select>

                <div className={classes.formItem}>
                    <input type='password' required placeholder='Password'/>
                </div>
                <div className={classes.formItem}>

                </div>

                <button className={classes.buttonLogIn}>Register</button>
                <a href="/#" className={classes.registerLink} onClick={() => props.changePage(true)}>
                    Already have an account? Log in here!
                </a>
            </form>
        </div>
    );
}

export default Registration;