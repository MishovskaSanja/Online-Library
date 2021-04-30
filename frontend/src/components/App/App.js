import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Route} from 'react-router-dom'
import Header from '../Header/header';
import LibraryService from '../../repository/libraryRepository';
import Books from '../Books/BookList/books';
import Categories from '../Categories/categories';
import BookAdd from '../Books/BookAdd/bookAdd';
import BookEdit from '../Books/BookEdit/bookEdit';

class App extends Component{

    constructor(props){
        super(props);
        this.state = {
            books: [],
            authors: [],
            countries: [],
            selectedBook: {},
            addedBook: {}
        }
    }

    render() {
        return (
            <Router>
            <Header/>
            <main>
            <div className="container">
            <Route path={"/books/add"} exact render={() =>
    <BookAdd authors={this.state.authors}
        countries={this.state.countries}
        onAddBook={this.addBook}/>}/>
        <Route path={"/books/edit/:id"} exact render={() =>
    <BookEdit authors={this.state.authors}
        countries={this.state.countries}
        onEditBook={this.editBook}
        book={this.state.selectedBook}/>}/>
        <Route path={["/", "/books"]} exact render={() =>
    <Books books={this.state.books}
        onRent={this.rentBook}
        onDelete={this.deleteBook}
        onEdit={this.getBook}/>}/>
        <Route path={"/categories"} exact render={() => <Categories/>}/>
        </div>
        </main>
        </Router>
    );
    }
    componentDidMount() {
        this.loadBooks();
        this.loadAuthors();
        this.loadCountries();
    }

    loadBooks = () => {
    LibraryService.fetchBooks()
.then((data) => {
    this.setState({
                      books: data.data
                  })
});
};

loadAuthors = () => {
    LibraryService.fetchAuthors()
        .then((data) => {
        this.setState({
            authors: data.data
        })
    });
};

loadCountries = () => {
    LibraryService.fetchCountries()
        .then((data) => {
        this.setState({
            countries: data.data
        })
    });
};

deleteBook = (id) => {
    LibraryService.deleteBook(id)
        .then(() => {
        this.loadBooks();
});
}

addBook = (book) => {
    LibraryService.addBook(book)
        .then(() => {
        this.loadBooks();
});
}

rentBook = (book) => {
    LibraryService.rentBook(book)
        .then(() => {
        this.loadBooks();
});
};

getBook = (id) => {
    LibraryService.getBook(id)
        .then((data) => {
        this.setState({
            selectedBook: data.data
        })
    })
};

editBook = (id, book) => {
    LibraryService.editBook(id, book)
        .then(() => {
        this.loadBooks();
});
}
}

export default App;
