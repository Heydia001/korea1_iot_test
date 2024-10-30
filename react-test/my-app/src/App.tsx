import React, { useEffect, useState } from 'react';
import './App.css';
import axios from 'axios';
import Button from '@mui/material/Button';

interface Book {
  id: number;
  author: string;
  title: string;
  category: string;
}

const DOMAIN = 'http://localhost:8080';
const MENU_API = 'api/test/books';

export default function App() {
  const [listResults, setListResults] = useState<Book[]>([]);
  // const [singleResult, setSingleResult] = useState<Book>();


  const fetchBookFindAll = async() => {
      try {
          const response  = await axios.get(
              `${DOMAIN}/${MENU_API}/list`
          )
          const data = response.data.data;

          setListResults(data);

      } catch (error) {
          console.error("Error fetching data: ", error);
      }
  }

  const handleBtnClick = (e:React.MouseEvent<HTMLButtonElement>) => {
      fetchBookFindAll();
  }

  return (
    <>
      <div
      style={{
        margin: '30'
      }}
      >
          <Button
            variant="contained"
            value='findAll'
            onClick={handleBtnClick}
            fullWidth
            sx={{
              width: 500,
              marginTop: 5,
              marginLeft:5,
              fontWeight: 700
            }}
          >
          전체 조회
          </Button>

          <ul
            style={{
              listStyleType:'none',
              // textAlign: 'center',
              borderRadius: '5px',
              width: 500
            }}
          >
              {listResults && listResults.length > 0 ? (
                  listResults.map((book) => (
                      <li key={book.id}
                        style={{
                          border:'solid 1px #ccc',
                          margin: '20px',
                          borderRadius: '5px',
                          padding:'20px',
                          lineHeight:'27px'
                        }} 
                      >
                        <span
                          style={{
                          backgroundColor:'	#1E90FF',
                          color: '#FFFFFF',
                          borderRadius: '5px',
                        }}
                        >&nbsp;TITLE&nbsp;</span> &nbsp;{book.title}
                        <br />
                        <span
                          style={{
                          backgroundColor:'	#1E90FF',
                          color: '#FFFFFF',
                          borderRadius: '5px'
                        }}
                        >&nbsp;AUTHOR&nbsp;</span> &nbsp;{book.author}
                        <br />
                        <span
                          style={{
                          backgroundColor:'	#1E90FF',
                          color: '#FFFFFF',
                          borderRadius: '5px'
                        }}
                        >&nbsp;CAREGORY&nbsp;</span> &nbsp;{book.category}
                      </li>
                  ))) : (
                  <li
                  style={{
                    border:'solid 1px #ccc',
                    borderRadius: '10px'
                  }}
                  >데이터 없음</li>
              )}
          </ul>
      </div>
    </>
  )
}