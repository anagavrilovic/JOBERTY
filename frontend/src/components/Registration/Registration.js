import { useState } from 'react';

import classes from './Registration.module.css';

import { useForm } from "react-hook-form";
import { yupResolver } from '@hookform/resolvers/yup';
import schema from "../../validationSchemas/RegisterValidationSchema";

function Registration(props) {

    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(schema)
    });

    const [serverError, setServerError] = useState(false);

    function registrationHandler(data) {

        const registrationRequest = {
            password: data.password,
            role: "USER",
            first_name: data.firstName,
            last_name: data.lastName,
            email: data.email,
            gender: data.gender === 'MALE' ? 0 : 1
        }

        console.log(registrationRequest);

        /*axiosInstance.post("registration", registrationRequest)
            .then(() => {
                props.changeMode('emailSent');
            })
            .catch((error) => {
                if (error.response.data.includes("email already exists")) {
                    setServerError(true);
                }
            })*/
    }

    function handleSelectGender(event) {
        event.target.style.color = '#3b3b3b';
    }

    return (
        <div className={classes.login}>
            <h1 className={classes.caption}>Register now!</h1>
            <form onSubmit={handleSubmit(registrationHandler)} className={classes.form}>

                <div className={classes.formItem}>
                    <input type='text' placeholder='First Name'
                        className={errors.firstName ? classes.errorInput : ''}
                        {...register("firstName")} />
                    <div className={classes.errorMessage}>{errors.firstName?.message}</div>
                </div>

                <div className={classes.formItem}>
                    <input type='text' placeholder='Last Name'
                        className={errors.lastName ? classes.errorInput : ''}
                        {...register("lastName")} />
                    <div className={classes.errorMessage}>{errors.lastName?.message}</div>
                </div>

                <div className={classes.formItem}>
                    <input type='text' placeholder='Email'
                        className={errors.email || serverError ? classes.errorInput : ''}
                        {...register("email")} />
                    <div className={classes.errorMessage}>{errors.email?.message}
                        {serverError ? "Account with this e-mail already exists." : ""}</div>
                </div>

                <div className={classes.formItem}>
                    <select name="Gender" defaultValue="" className={`${classes.select} ${errors.gender ? classes.errorInput : ''}`}
                        {...register("gender")}
                        onChange={handleSelectGender}>
                        <option value="" disabled>Gender</option>
                        <option value="MALE" >Male</option>
                        <option value="FEMALE" >Female</option>
                    </select>
                    <div className={classes.errorMessage}>{errors.gender?.message}</div>
                </div>

                <div className={`${classes.formItem} ${classes.password}`}>
                    <input type='password' placeholder='Password'
                        className={`${errors.password?.message === 'Password is too weak.' || errors.password?.message === 'Password is required.' ? classes.errorInput : ''}
                        ${errors.password?.message === 'Password has medium strength.' ? classes.mediumStrengthPassword : ''}
                        ${!errors?.password && false ? classes.passwordStrong : ''}`}
                        {...register("password")} />
                    <div className={classes.tooltip}>Strong password must be at least 10 characters long, including at least 1 uppercase letter, 1 lowercase letter, 1 numeric character and 1 special character.</div>
                    <div className={`${classes.errorMessage} 
                        ${errors.password?.message === 'Password has medium strength.' ? classes.errorMessagePasswordWeak : ''}`}>{errors.password?.message}</div>
                </div>

                <div className={classes.formItem}>
                    <input type='password' placeholder='Confirm Password'
                        className={errors.confirmPassword ? classes.errorInput : ''}
                        {...register("confirmPassword")} />
                    <div className={classes.errorMessage}>{errors.confirmPassword?.message}</div>
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