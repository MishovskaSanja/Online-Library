import axios from "../custom-axios/axios";

const LibraryService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    fetchCountries: () => {
        return axios.get("/countries");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addBook: (book) => {
        return axios.post("/books/add", book);
    },
    rentBook: (book) => {
        return axios.post(`/books/rent/${book}`);
    },
    editBook: (id, book) => {
        return axios.put(`/books/edit/${id}`, book);
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    }
};

export default LibraryService;
