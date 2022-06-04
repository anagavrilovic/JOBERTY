import React, { useState, useEffect } from 'react';
import classes from './MyCompany.module.css';
import { useSelector } from 'react-redux';

import Caption from "../../components/Caption/Caption";

import { useForm } from "react-hook-form";
import { yupResolver } from '@hookform/resolvers/yup';
import schema from "../../validationSchemas/RegisterCompanyValidationSchema";
import { axiosInstance } from "../../api/AxiosInstance"

function MyCompany() {

    const [company, setCompany] = useState();
    const [editMode, setEditMode] = useState(false);
    const [serverError, setServerError] = useState(false);

    const user = useSelector((state) => state.user.value);

    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(schema)
    });

    useEffect(() => {
        const config = {
            headers: {
                'Content-Type': 'application/json;charset=UTF-8',
                Accept: 'application/json',
                'Authorization': `Bearer ${user.accessToken}`
            }
        }

        axiosInstance.get(`/auth/whoami`, config)
            .then((response) => {
                axiosInstance.get(`/company/${response.data.email}`)
                    .then((response1) => {
                        setCompany(response1.data);
                    })
            })
    }, []);

    function onChange(e) {
        this.setState({ [e.target.name]: e.target.value })
    }

    function changeEditMode(e) {
        e.preventDefault();
        setEditMode(true)
    }

    function handleEditProfile(data) {
        console.log(data);
    }

    return (
        <div className={classes.page}>
            <div className={classes.header}>
                <Caption caption="My Company" />
            </div>
            <div>
                <form onSubmit={editMode ? handleSubmit(handleEditProfile) : changeEditMode} className={classes.content}>
                    <div className={classes.contentRow}>
                        <div className={classes.inputForm}>
                            <p className={classes.inputLabel}>Company Name</p>
                            <input type="text" placeholder='Company Name' disabled={!editMode}
                                value={company ? company.name : null} 
                                className={`${classes.input} ${errors.companyName ? classes.errorInput : ""}`}
                                {...register("companyName")} />
                            <div className={classes.errorMessage}>{errors.companyName?.message}</div>
                        </div>

                        <div className={classes.inputForm}>
                            <p className={classes.inputLabel}>Email</p>
                            <input type="text" placeholder='Email' disabled={true}
                                className={`${classes.input} ${errors.email ? classes.errorInput : ""}`}
                                {...register("email")} />
                            <div className={classes.errorMessage}>{errors.email?.message}</div>
                        </div>

                        <div className={classes.inputForm}>
                            <p className={classes.inputLabel}>Website</p>
                            <input type="text" placeholder='Website' disabled={!editMode}
                                className={`${classes.input} ${errors.website ? classes.errorInput : ""}`}
                                {...register("website")} />
                            <div className={classes.errorMessage}>{errors.website?.message}</div>
                        </div>

                        <div className={classes.inputForm}>
                            <p className={classes.inputLabel}>Description</p>
                            <textarea type="text" placeholder='Description' disabled={!editMode}
                                className={`${classes.textarea} ${errors.description ? classes.errorTextarea : ""}`}
                                {...register("description")} />
                            <div className={classes.errorMessage}>{errors.description?.message}</div>
                        </div>
                    </div>
                    <div className={classes.contentRow}>
                        <div className={classes.inputForm}>
                            <p className={classes.inputLabel}>Industry</p>
                            <input type="text" placeholder='Industry' disabled={!editMode}
                                className={`${classes.input} ${errors.industry ? classes.errorInput : ""}`}
                                {...register("industry")} />
                            <div className={classes.errorMessage}>{errors.industry?.message}</div>
                        </div>

                        <div className={classes.inputForm}>
                            <p className={classes.inputLabel}>Origin</p>
                            <input type="text" placeholder='Origin' disabled={!editMode}
                                className={`${classes.input} ${errors.origin ? classes.errorInput : ""}`}
                                {...register("origin")} />
                            <div className={classes.errorMessage}>{errors.origin?.message}</div>
                        </div>

                        <div className={classes.inputForm}>
                            <p className={classes.inputLabel}>Offices in</p>
                            <input type="text" placeholder='Offices in' disabled={!editMode}
                                className={`${classes.input} ${errors.cities ? classes.errorInput : ""}`}
                                {...register("cities")} />
                            <div className={classes.errorMessage}>{errors.cities?.message}</div>
                        </div>

                        <div className={classes.inputForm}>
                            <p className={classes.inputLabel}>Number of Employees</p>
                            <input type="text" placeholder='Number of Employees' disabled={!editMode}
                                className={`${classes.input} ${errors.companySize ? classes.errorInput : ""}`}
                                {...register("companySize")} />
                            <div className={classes.errorMessage}>{errors.companySize?.message}</div>
                        </div>

                        <div className={classes.buttons}>
                            <button className={classes.buttonPassword}>Change password</button>
                            <button type='submit' className={classes.button}>
                                {editMode ? "Save changes" : "Edit profile"}
                            </button>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    )
}

export default MyCompany