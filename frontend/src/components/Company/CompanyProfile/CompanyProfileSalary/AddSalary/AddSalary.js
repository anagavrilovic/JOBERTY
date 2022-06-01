import React, { useEffect, useState } from 'react'
import { addSalaryInfo, getPositionsByCompany } from '../../../../../api/CompanyApi'
import classes from './AddSalary.module.css'

const AddSalary = ({ toggleAddSalary, company, reload }) => {
    const [salary, setSalary] = useState({positionId: 1, userId: 1});
    const [positions, setPositions] = useState([]);

    useEffect(() => {
        async function getPositions(){
            const results = await getPositionsByCompany(company.id);
            setPositions(results);
        }

        getPositions();

    }, [company]);


    function onPositionSelected(e) {
        setSalary(prev => ({ ...prev, positionId: parseInt(e.target.value) }));
    }

    function onAmountChange(e){
        setSalary(prev => ({ ...prev, amountInEur: e.target.value }));
    }

    function onSaveSalaryInformation(e){
        e.preventDefault();
        addSalaryInfo(salary).then(() => {
            reload();
            toggleAddSalary();
        })

    }

    return (
        <div className={classes.fallback} onClick={toggleAddSalary}>
            <div className={classes.modal} onClick={e => e.stopPropagation()}>
                <form>
                    <div className={classes.header}>
                        <span> Add salary information </span>
                        <span className={classes.close} onClick={toggleAddSalary}>&times;</span>

                    </div>
                    <div className={classes.body}>
                        <div className={classes.fieldTitle}>
                            <span> Available positions </span>
                        </div>
                        <select className={classes.select} onChange={onPositionSelected}>
                            {positions.map((pos) => <option key={pos.id} value={pos.id} className={classes.selectOption} >{pos.title} ({pos.seniority})</option>)}
                        </select>

                        <div className={classes.fieldTitle}>
                            <span> Amount in EUR </span>
                        </div>
                        <input type="number" className={classes.input} id="salaryAmount" onChange={onAmountChange} required></input>
                    </div>

                    <div className={classes.footer}>
                        <input type="submit" className={classes.saveButton} value="Save" onClick={onSaveSalaryInformation}/>
                    </div>
                </form>
            </div>

        </div>
    )
}

export default AddSalary