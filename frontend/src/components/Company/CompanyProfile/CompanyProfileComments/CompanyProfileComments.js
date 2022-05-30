import React from 'react';
import StarRate from '../../../StarRate/StarRate';
import classes from './CompanyProfileComments.module.css';

function CompanyProfileComments() {
    const comments = [1, 2, 3, 4];

    const comment = {
        rate: 4.5,
        caption: "A decent career development company",
        dateCreated: "20.04.2022",
        comment: "A sense of protection from the client from the side of the company. Regular raises, juniors can also expect a raise if they show up okay. Team spirit, although this may depend on the team, I am not sure. Technologies are diverse, and the possibility of switching to another technology is also possible. Enabled knowledge and career development through udemy and various certifications.",
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