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

    function handleSelectGender(event) {
        event.target.style.color = '#3b3b3b';
    }

    return (
        <div className={classes.login}>
            <h1 className={classes.caption}>Register now!</h1>
            <form onSubmit={registrationHandler} className={classes.form}>

                <div className={classes.formItem}>
                    <input type='text' required placeholder='First Name' />
                </div>
                
                <div className={classes.formItem}>
                    <input type='text' required placeholder='Last Name' />
                </div>

                <div className={classes.formItem}>
                    <input type='text' required placeholder='Email' />
                </div>

                <select name="Gender" defaultValue="" className={classes.select} onChange={handleSelectGender} >
                    <option value="" disabled>Gender</option>
                    <option value="MALE" >Male</option>
                    <option value="FEMALE" >Female</option>
                </select>

                <div className={classes.formItem}>
                    <input type='password' required placeholder='Password' />
                </div>

                <div className={classes.formItem}>
                    <input type='password' required placeholder='Confirm Password' />
                </div>

                <button className={classes.buttonLogIn}>Register</button>
                <a href="/#" className={classes.registerLink} onClick={() => props.navigateToLogin()}>
                    Already have an account? Log in here!
                </a>
            </form>
        </div>
    );
}

export default Registration;