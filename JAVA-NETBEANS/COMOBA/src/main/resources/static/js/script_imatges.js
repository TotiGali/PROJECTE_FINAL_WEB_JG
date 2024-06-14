        document.getElementById('uploadForm').addEventListener('submit', async function(event) {
            event.preventDefault();

            const formData = new FormData();
            formData.append('imageFile', document.getElementById('imageFile').files[0]);

            const response = await fetch('/upload', {
                method: 'POST',
                body: formData
            });

            if (response.ok) {
                alert('Imagen subida correctamente');
            } else {
                alert('Error al subir la imagen');
            }
        });

        document.getElementById('getAllImagesButton').addEventListener('click', async function() {
            await loadAllImages();
        });

        document.getElementById('getImageByIdButton').addEventListener('click', async function() {
            const imageId = document.getElementById('imageIdInput').value;
            if (imageId) {
                await loadImageById(imageId);
            } else {
                alert('Por favor, introduce un ID de imagen.');
            }
        });

        async function loadAllImages() {
            const response = await fetch('/images');
            if (response.ok) {
                const imageIds = await response.json();
                const allImagesDiv = document.getElementById('allImages');
                allImagesDiv.innerHTML = ''; // Clear existing images

                for (const imageId of imageIds) {
                    const imgResponse = await fetch(`/image/${imageId}`);
                    const blob = await imgResponse.blob();
                    const imgURL = URL.createObjectURL(blob);
                    const imgElement = document.createElement('img');
                    imgElement.src = imgURL;
                    imgElement.alt = `Imagen ${imageId}`;
                    imgElement.style.margin = '10px';
                    imgElement.width = 150;
                    allImagesDiv.appendChild(imgElement);
                }
            } else {
                alert('Error al cargar las imágenes');
            }
        }

        async function loadImageById(imageId) {
            const imgResponse = await fetch(`/image/${imageId}`);
            if (imgResponse.ok) {
                const blob = await imgResponse.blob();
                const imgURL = URL.createObjectURL(blob);
                const imgElement = document.getElementById('retrievedImage');
                imgElement.src = imgURL;
                imgElement.style.display = 'block';
            } else {
                alert('Error al cargar la imagen con ID ' + imageId);
            }
        }