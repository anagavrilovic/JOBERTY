import React, { useEffect,useState } from 'react'
import classes from './CreateJobOffer.module.css';
import { useForm } from 'react-hook-form';
import TextareaAutosize from 'react-textarea-autosize';
import { useNavigate } from 'react-router';
import CompanyService from '../../../services/CompanyService';
import JobOfferService from '../../../services/JobOfferService';

const CreateJobOffer = () => {
    const {register,handleSubmit, formState: { errors }} = useForm({})
    const [companies,setCompanies] = useState([])
        const navigate = useNavigate()
    const onSubmit = handleSubmit((data) =>{
        console.log(companies)
        console.log(data)
        let company = companies.filter(comp=> comp.company.id == data.company)
        const jobOffer = {
            position : data.position,
            jobDescription : data.description,
            prerequisites : data.prerequisites,
            company : company[0].company,
            employment_type: parseInt(data.type)
        }
        console.log(jobOffer)
        JobOfferService.save(jobOffer).then(resp=>{
            console.log(resp.data)
            navigate('/jobs')
        })
    })

    useEffect(()=>{
        CompanyService.getAll().then(resp=>{
            console.log(resp.data)
            setCompanies(resp.data)
        })
    },[])
    function getBack(){
        navigate('/jobs')
    }

  return (
    <div className={classes.page}>
            <div className={classes.form}>
            <form onSubmit={onSubmit}>
        <div className={classes.formItem}>
        <label htmlFor="func" className="form_label">
                Job position*
            </label>
        <input
                {...register("position", {required: {value:true,message:'Position is required'}})}
                type="text" 
                placeholder="Job title"
                 />
                 {
                   errors.position && <div className={classes.error}><label>{errors.position.message}</label></div>
                }
        </div>
        <div className={classes.formItem}>
        <label htmlFor="func" className="form_label">
                Job description*
            </label>
            <TextareaAutosize 
            className={classes.textarea}
                {...register("description", {required: {value:true,message:'Description is required'}})}
                type="text" 
                placeholder="Job description"
                 />
                 {
                   errors.description && <div className={classes.error}><label>{errors.description.message}</label></div>
                }
        </div>
        <div className={classes.formItem}>
        <label htmlFor="func" className="form_label">
        Prerequisites*
            </label>
            <TextareaAutosize 
            className={classes.textarea}
                {...register("prerequisites", {required: {value:true,message:'Prerequisites is required'}})}
                type="text" 
                placeholder="Prerequisites"
                 />
                 {
                   errors.prerequisites && <div className={classes.error}><label>{errors.prerequisites.message}</label></div>
                }
        </div>
        <div className={classes.formItem}>
            <label htmlFor="func" className="form_label">
                Employment type*
            </label>
            <select name="func" 
            className={classes.select}
            {...register("type", {required: {value:true,message:'Type is required'}})}>
            <option value=""></option>
            <option value="0">Full time</option>
            <option value="1">Part time</option>
            <option value="2">Internship</option>
            </select>
                 {
                   errors.type && <div className={classes.error}><label>{errors.type.message}</label></div>
                }
        </div>
        <div className={classes.formItem}>
            <label htmlFor="func" className="form_label">
                Company*
            </label>
            <select name="func" 
            className={classes.select}
            {...register("company", {required: {value:true,message:'Company is required'}})}>
            <option value=""></option>
            {
                companies.map((company,i)=>
                    <option key={i} value={company.company.id}>{company.company.name}</option>
                )
            }
            </select>
                 {
                   errors.company && <div className={classes.error}><label>{errors.company.message}</label></div>
                }
        </div>

        <button className={classes.buttonLogIn}>Create job offer</button>
        <button className={classes.buttonBack} onClick={getBack}>Back</button>
    </form>
            </div>
        </div>
  )
}

export default CreateJobOffer