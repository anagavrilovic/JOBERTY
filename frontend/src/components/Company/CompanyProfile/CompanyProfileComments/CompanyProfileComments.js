import React from 'react';
import StarRate from '../../../StarRate/StarRate';
import classes from './CompanyProfileComments.module.css';

function CompanyProfileComments() {
    const comments = [1, 2, 3, 4];

    const comment = {
        rate: 4.5,
        caption: "Pristojna kompanija za razvoj karijere",
        dateCreated: "20.04.2022",
        comment: "Osecaj zasticenosti od klijenta sa starne kompanije. Redovne povisice, juniori isto mogu da ocekuju povisicu ukoliko se okej pokazu. Timski duh, mada ovo mozda zavisi od tima, nisam siguan. Tehnologije su raznovrsne, i mogucnost prebacaja na drugu tehnologiju je isto moguc. Omogucen razvoj znanja i karijere kroz udemy i raznorazne sertifikacije. ",
        job: "Software Developer (Junior)",
        currentlyWorking: true
    }

    return (
        <div className={classes.comments}>
            {comments.map((c) => {
                return <div key={c} className={classes.comment}>
                    <div className={classes.commentHeader}>
                        <div className={classes.commentRate}>
                            <p className={classes.rate}>{comment.rate}</p>
                            <StarRate rate={comment.rate}/>
                        </div>
                        <div className={classes.caption}>
                            <h3 className={classes.captionText}>{comment.caption}</h3>
                            <p className={classes.date}>{comment.dateCreated}</p>
                        </div>
                    </div>
                    <div className={classes.commentContent}>
                        <p className={classes.commentText}>{comment.comment}</p>
                        <p className={classes.authorInfo}>{comment.job}</p>
                        <p className={classes.authorInfo}>{comment.currentlyWorking ? "Currently working in this company" : "Not working anymore in this company"}</p>
                    </div>
                </div>
            })}
        </div>
    )
}

export default CompanyProfileComments