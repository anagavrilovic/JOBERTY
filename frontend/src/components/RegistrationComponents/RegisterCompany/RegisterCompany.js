import React from 'react';
import classes from './RegisterCompany.module.css';

import { useState } from 'react';
import { useForm } from "react-hook-form";
import { yupResolver } from '@hookform/resolvers/yup';
import schema from "../../../validationSchemas/RegisterCompanyValidationSchema";

function RegisterCompany(props) {

    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(schema)
    });

    const [serverError, setServerError] = useState(false);

    function registrationHandler(data) {

        const registrationRequest = {
            password: data.password,
            role: "COMPANY",
            company_name: data.companyName,
            cities: data.cities,
            email: data.email,
            website: data.website,
            company_size: data.companySize,
            industry: data.industry
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
        <div className={classes.component}>
            <form onSubmit={handleSubmit(registrationHandler)} className={classes.form}>

                <div className={classes.formItem}>
                    <input type='text' placeholder='Company Name'
                        className={errors.companyName ? classes.errorInput : ''}
                        {...register("companyName")} />
                    <div className={classes.errorMessage}>{errors.companyName?.message}</div>
                </div>

                <div className={classes.formItem}>
                    <input type='text' placeholder='Email'
                        className={errors.email ? classes.errorInput : ''}
                        {...register("email")} />
                    <div className={classes.errorMessage}>{errors.email?.message}
                        {serverError ? "Account with this e-mail already exists." : ""}</div>
                </div>

                <div className={classes.formItem}>
                    <input type='text' placeholder='Website'
                        className={errors.website || serverError ? classes.errorInput : ''}
                        {...register("website")} />
                    <div className={classes.errorMessage}>{errors.website?.message}</div>
                </div>

                <div className={classes.formItem}>
                    <input type='text' placeholder='Cities'
                        className={errors.cities || serverError ? classes.errorInput : ''}
                        {...register("cities")} />
                    <div className={classes.errorMessage}>{errors.cities?.message}</div>
                </div>

                <div className={classes.formItem}>
                    <input type='text' placeholder='Company Size'
                        className={errors.companySize || serverError ? classes.errorInput : ''}
                        {...register("companySize")} />
                    <div className={classes.errorMessage}>{errors.companySize?.message}</div>
                </div>

                <div className={classes.formItem}>
                    <input type='text' placeholder='Industry'
                        className={errors.industry || serverError ? classes.errorInput : ''}
                        {...register("industry")} />
                    <div className={classes.errorMessage}>{errors.industry?.message}</div>
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
            </form>
        </div>
    )
}

export default RegisterCompany