import React from 'react';
import classes from './CompanyProfileInterview.module.css';
import StarRate from '../../../StarRate/StarRate';

function CompanyProfileInterview() {
    const comments = [1, 2, 3, 4];

    const comment = {
        rate: 4.5,
        caption: "Great!",
        dateCreated: "20.04.2022",
        hrInterview: "The company introduced itself, the person who conducted the interview was very pleasant and answered all my questions. Nicely explained how the interview will be conducted and what is expected of me. They were also always available for additional information.",
        technicalInterview: "They are not too difficult. One task that everyone should be able to solve if they have passed some basic pogam constructions and have okay logic. List of trick questions. It can happen that it can get worse easily, but everything can be justified and corrected in the oral part of the interview.",
        job: "Software Developer (Junior)",
        state: 'Accepted offer'
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
                        <p className={classes.boldText}>HR Interview</p>
                        <p className={classes.commentText}>{comment.hrInterview}</p>
                        <p className={classes.boldText}>Technical Interview</p>
                        <p className={classes.commentText}>{comment.technicalInterview}</p>
                        <p className={classes.authorInfo}>{comment.job}</p>
                        <p className={classes.authorInfo}>{comment.state}</p>
                    </div>
                </div>
            })}
        </div>
    )
}

export default CompanyProfileInterview