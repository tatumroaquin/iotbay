CREATE TABLE Cities(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(25) NOT NULL
);

INSERT INTO Cities(name) VALUES 
('Adelaide'),
('Albany'),
('Albury'),
('Alice Springs'),
('Armidale'),
('Ballarat'),
('Bathurst'),
('Bendigo'),
('Brisbane'),
('Broken Hill'),
('Bunbury'),
('Bundaberg Central'),
('Busselton'),
('Cairns'),
('Canberra'),
('Coffs Harbour'),
('Darwin'),
('Devonport'),
('Dubbo'),
('Geelong'),
('Geraldton'),
('Gladstone Central'),
('Gold Coast'),
('Goulburn'),
('Hervey Bay'),
('Hobart'),
('Kalgoorlie Boulder'),
('Launceston'),
('Lismore'),
('Mackay'),
('Melbourne'),
('Mildura'),
('Mount Gambier'),
('Newcastle'),
('Nowra'),
('Orange'),
('Perth'),
('Port Agusta'),
('Port Lincoln'),
('Queanbeyan'),
('Rockhampton'),
('Shepparton'),
('Sydney'),
('Tamworth'),
('Toowoomba'),
('Townsville'),
('Traralgon'),
('Wagga'),
('Warrnambool'),
('Whyalla'),
('Wollogong');
