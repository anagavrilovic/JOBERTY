import React, {useState} from 'react'
import { addComment } from '../../../../../api/CompanyApi';
import InteractiveStarRate from '../../../../StarRate/InteractiveStarRate/InteractiveStarRate'
import classes from "./AddComment.module.css"

const AddComment = ({ toggleAddComment, company, reload }) => {
    const [comment, setComment] = useState({ mark: 0, currentlyWorking: false, companyId: company.id, userId: 1 });

    function ratingChanged(value) {
        setComment(prev => ({ ...prev, mark: parseFloat(value) }));
    }

    function onCommentChange(e) {
        const element = e.target.id;
        const value = e.target.value;

        switch (element) {
            case "commentCaption":
                setComment(prev => ({ ...prev, caption: value }));
                break;
            case "commentIsCurrentlyWorking":
                setComment(prev => ({ ...prev, currentlyWorking: e.target.checked }));
                break;
            case "commentText":
                setComment(prev => ({ ...prev, text: value }));
                break;
            default:
                console.log("default")
        }

    }

    function onCommentSave(e){
        e.preventDefault();
        console.log(comment);
        addComment(comment).then(() => {
            reload();
            toggleAddComment();
        });
    }

    return (
        <div className={classes.fallback} onClick={toggleAddComment}>
            <div className={classes.modal} onClick={e => e.stopPropagation()}>
                <form>
                    <div className={classes.header}>
                        <span> Add comment </span>
                        <span className={classes.close} onClick={toggleAddComment}>&times;</span>

                    </div>
                    <div className={classes.body}>
                        <div className={classes.fieldTitle}>
                            <span> Caption </span>
                        </div>
                        <input type="text" className={classes.input} id="commentCaption" onChange={onCommentChange} required></input>

                        <div className={classes.fieldTitle}>
                            <span> Text </span>
                        </div>
                        <textarea className={classes.inputArea} id="commentText" onChange={onCommentChange} required></textarea>

                        <div className={classes.fieldTitle}>
                            <span className={classes.ratingTitle}> Leave a rating </span>
                        </div>
                        <InteractiveStarRate ratingChanged={ratingChanged} />

                        <div className={classes.row}>
                            <input type="checkbox" className={classes.checkbox} id="commentIsCurrentlyWorking" onChange={onCommentChange}></input>
                            <label> I am currently working at this role </label>
                        </div>
                    </div>

                    <div className={classes.footer}>
                        <input type="submit" className={classes.saveButton} value="Save" onClick={onCommentSave}/>
                    </div>
                </form>
            </div>

        </div>
    )
}

export default AddComment