import React from 'react';
import {useHistory} from 'react-router-dom';

const BookEdit = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        category: "",
        author: 1,
        availableCopies: 0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.book.name;
        const category = formData.category !== "" ? formData.category : props.book.category;
        const author = formData.author !== {} ? formData.author : props.book.author;
        const availableCopies = formData.availableCopies !== 0 ? formData.availableCopies : props.book.availableCopies;

        const book = {name, category, author, availableCopies};
        props.onEditBook(props.book.id, book);
        history.push("/books");
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder={props.book.name}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {
                                props.book.category === "NOVEL" ? (<option selected="true" value="NOVEL">NOVEL</option>) : (<option value="NOVEL">NOVEL</option>)
                            }
                            {
                                props.book.category === "THRILER" ? (<option selected="true" value="THRILER">THRILER</option>) : (<option value="THRILER">THRILER</option>)
                            }
                            {
                                props.book.category === "HISTORY" ? (<option selected="true" value="HISTORY">HISTORY</option>) : (<option value="HISTORY">HISTORY</option>)
                            }
                            {
                                props.book.category === "FANTASY" ? (<option selected="true" value="FANTASY">FANTASY</option>) : (<option value="FANTASY">FANTASY</option>)
                            }
                            {
                                props.book.category === "BIOGRAPHY" ? (<option selected="true" value="BIOGRAPHY">BIOGRAPHY</option>) : (<option value="BIOGRAPHY">BIOGRAPHY</option>)
                            }
                            {
                                props.book.category === "CLASSICS" ? (<option selected="true" value="CLASSICS">CLASSICS</option>) : (<option value="CLASSICS">CLASSICS</option>)
                            }
                            {
                                props.book.category === "DRAMA" ? (<option selected="true" value="DRAMA">DRAMA</option>) : (<option value="DRAMA">DRAMA</option>)
                            }
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) => {
                                if(props.book.author !== undefined &&
                                    props.book.author.id === term.id)
                                    return <option selected={props.book.author.id} value={term.id}>{term.name} {term.surname}</option>
                                else return <option value={term.id}>{term.name} {term.surname}</option>
                            })}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="availableCopies">Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.book.availableCopies}
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default BookEdit;